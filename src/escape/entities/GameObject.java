package escape.entities;

public abstract class GameObject {
    protected  String name;
    protected String description;

    public GameObject(String name, String description){
        this.name = name;
        this.description=description;
    }
    public String getname(){
        return name;
    }
    public abstract String inspectResponse();
}
