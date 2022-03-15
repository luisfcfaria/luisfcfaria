package academy.mindswap.persistence;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "students")
public class Student {
    @Id
    @Column(name = "id_card")
    private Integer IdCard;

    @Column (length = 50)
    private String name;

    @Column
    private Integer edition;

    public Student(Integer idCard, String name, Integer edition) {
        IdCard = idCard;
        this.name = name;
        this.edition = edition;
    }

    public Student() {
    }

    public Integer getIdCard() {
        return IdCard;
    }

    public void setIdCard(Integer idCard) {
        IdCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Student{" +
                "IdCard=" + IdCard +
                ", name='" + name + '\'' +
                ", edition=" + edition +
                '}';
    }
}
