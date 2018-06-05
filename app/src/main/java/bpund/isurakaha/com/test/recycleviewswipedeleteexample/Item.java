package bpund.isurakaha.com.test.recycleviewswipedeleteexample;

/**
 * Created by isuraksha3 on 4/5/2018.
 */

public class Item {

 /*   ArrayList<Menu> menus = new Menu();

    public Menu getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }
*/


        int id;
        String name;
        String description;
        double price;
        String thumbnail;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }


}
