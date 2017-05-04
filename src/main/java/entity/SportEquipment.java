package entity;

/**
 * Created by vbokh on 02.05.2017.
 */
public class SportEquipment{
    private Category category;
    private String title;
    private int price;

    public SportEquipment(Category category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Category : " + getCategory() + ", title : " + getTitle() + ", price : " + getPrice();
    }

    @Override
    public int hashCode() {
        int i = 31;
        return i*category.hashCode() + ((title ==null)? 0 : title.hashCode()) + price;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass()!= obj.getClass()){
            return false;
        }
        SportEquipment eq = (SportEquipment) obj;

        if(category != eq.category){
            return false;
        }
        if(price != eq.price){
            return false;
        }
        if(title==null){
            if(eq.title!=null){
                return false;
            }
        }else if(!title.equals(eq.title)){
            return false;
        }
        return true;
    }
}
