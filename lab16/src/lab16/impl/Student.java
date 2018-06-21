package lab16.impl;


public class Student implements Comparable {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Object student) {
        Student st = (Student) student;

        return name.compareTo(st.getName());
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
           Student st = (Student) obj;
           return st.getId() == id;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "{"+name+": "+id+"}";
    }
    
}