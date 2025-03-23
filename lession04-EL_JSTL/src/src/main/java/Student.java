public class Student {
    private Integer id;
    private String name;
    private Integer num;


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public Integer getNum() {return num;}
    public void setNum(Integer num) {this.num = num;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
