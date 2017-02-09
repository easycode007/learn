package mylibrary;

/**
 * Created by Razvan on 09.02.2017.
 */
public class Client implements Person {
    private String name;
    private int id;

    public Client(int id, String name) {
        if(name == null || name.isEmpty()) {
            
        }
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!Person.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Person other = (Person) obj;
        if((this.name == null) ? (other.getName() == null) : !this.name.equals(other.getName())) {
            return false;
        }
        if(this.id != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.id * 2 * this.name.hashCode();
    }
}
