package mk.ukim.finki.wp.kol2022.g1.service.Imp;

import mk.ukim.finki.wp.kol2022.g1.model.Employee;
import mk.ukim.finki.wp.kol2022.g1.model.EmployeeType;
import mk.ukim.finki.wp.kol2022.g1.model.Skill;
import mk.ukim.finki.wp.kol2022.g1.model.exceptions.InvalidEmployeeIdException;
import mk.ukim.finki.wp.kol2022.g1.model.exceptions.InvalidSkillIdException;
import mk.ukim.finki.wp.kol2022.g1.repository.EmployeeRepository;
import mk.ukim.finki.wp.kol2022.g1.repository.SkillRepository;
import mk.ukim.finki.wp.kol2022.g1.service.EmployeeService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImp implements EmployeeService, UserDetailsService {
    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;
    private final PasswordEncoder passwordEncoder;

    public EmployeeServiceImp(EmployeeRepository employeeRepository, SkillRepository skillRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Employee> listAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(InvalidEmployeeIdException::new);
    }

    @Override
    public Employee create(String name, String email, String password,
                           EmployeeType type, List<Long> skillId,
                           LocalDate employmentDate) {
        List<Skill> skillList = skillId.stream()
                .map(id->this.skillRepository
                        .findById(id).orElseThrow(InvalidSkillIdException::new)).collect(Collectors.toList());
        Employee employee = new Employee(name,email,passwordEncoder.encode(password),type,skillList,employmentDate);
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, String name, String email,
                           String password, EmployeeType type,
                           List<Long> skillId, LocalDate employmentDate) {
        Employee e = this.employeeRepository.findById(id).orElseThrow(InvalidEmployeeIdException::new);
        List<Skill> skillList = skillId.stream()
                        .map(i->this.skillRepository.findById(i).orElseThrow(InvalidSkillIdException::new))
                                .collect(Collectors.toList());
        e.setEmail(email);
        e.setName(name);
        e.setPassword(passwordEncoder.encode(password));
        e.setType(type);
        e.setEmploymentDate(employmentDate);
        e.setSkills(skillList);
        return this.employeeRepository.save(e);
    }

    @Override
    public Employee delete(Long id) {
        Employee e= this.employeeRepository.findById(id).orElseThrow(InvalidEmployeeIdException::new);
        this.employeeRepository.deleteById(id);
        return e;
    }

    @Override
    public List<Employee> filter(Long skillId, Integer yearsOfService) {
        Skill skill = this.skillRepository.findById(skillId).orElseThrow(InvalidSkillIdException::new);
        List<Employee> employees=this.employeeRepository.findAll();
        LocalDate localDate =LocalDate.now();

        employees = employees.stream().filter(employee -> {
            Period period = localDate.until(employee.getEmploymentDate());
            int yearsBetween = period.getYears();
            return yearsBetween == yearsOfService;
        }).collect(Collectors.toList());
        Skill  sKill=this.skillRepository.findById(skillId)
                .orElseThrow(InvalidSkillIdException::new);
        employees=employeeRepository.findAllBySkillsContaining((Skill) sKill);

        return employees;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee e = this.employeeRepository.findEmployeeByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(email));
        UserDetails userDetails= new org.springframework.security.core.userdetails
                .User(e.getEmail(),
                e.getPassword(),
                Stream.of(new SimpleGrantedAuthority
                        (e.getType().toString())).collect(Collectors.toList()));
        return userDetails;
    }

}
