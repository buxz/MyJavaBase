package bxz.base.hashmap;

public class Keys {
    private Integer id;

    public Keys(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Keys)){
            return false;
        }else {
            return this.getId().equals(((Keys) obj).getId());
        }
    }
}
