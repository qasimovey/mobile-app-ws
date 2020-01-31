package org.qasimovey.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private long Id;

    @NotNull(message = "FirstName teyin olunmayib")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull(message = "LastName  teyin olunmayib")
    @Column(name = "LAST_NAME")
    private String lastName;


    @NotNull(message = "Email xanasi bos ola bilmez")
    @Email(message = "Email formati duzgun deyil")
    @Size(min = 1)
    @Column(name="EMAILL")
    private String email;

    @Column(name = "SALARY")
    private long Salary;

    @Column(name = "HIRE_DATE")
    private Date Hiring_date;

    @Column(name = "DEPARTMENT_ID")
    private int Department_id;

}
