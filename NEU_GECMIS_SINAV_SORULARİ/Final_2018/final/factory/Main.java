interface Mobile {
    public static final String IPHONE="IPHONE";
    public static final String SONY="sony";
    public static final String SAMSUNG="samsung";
}

class IPhone implements Mobile{
    private int ramSize;
    private String processor;
    private String GPU;
    public IPhone(int ramSize, String processor, String GPU){
        this.ramSize = ramSize;
        this.processor = processor;
        this.GPU = GPU;
    }
}

class Samsung implements Mobile{
    private int ramSize;
    private String processor;
    public String name = Mobile.SAMSUNG;
    public Samsung(int ramSize){
        this.ramSize = ramSize;
    }

    public Samsung(String processor){
        this.processor = processor;
        this.ramSize =2;
    }

}

class Sony implements Mobile{
    private int ramSize;
    private String processor;

    public Sony(int ramSize, String processor){
        this.ramSize = ramSize;
        this.processor = processor;
    }
}
class MobileFactory {
    public static Mobile createMobile(String type){
        if(type.equals(Mobile.IPHONE)){
            return new IPhone(2, "A9", "A9 GPu");
        }else if(type.equals(Mobile.SONY)){
            return new Sony(2,"ARM");
        }else if(type.equals(Mobile.SAMSUNG)){
            return new Samsung("Intel");
        }else{
            return null;
        }
    }
}

public class Main{

        public static void main(){

            Mobile mobile = MobileFactory.createMobile(Mobile.SAMSUNG);
        }

}
