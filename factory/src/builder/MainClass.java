package builder;

public class MainClass {

    public static void main(String[] args) {
        //客户直接建房子
/*        House house = new House();
        house.setFloor("地板");
        house.setWall("墙");
        house.setHousetop("屋顶");*/

        //工程队修
        HouseBuilder builder = new PingFangBuilder();
        //调用工程队来修
        HouseDicrector dicrector = new HouseDicrector();
        dicrector.makeHouse(builder);
        House house = builder.getHouse();
        System.out.println(house.getFloor());
        System.out.println(house.getWall());
        System.out.println(house.getHousetop());

        //工程队修
        HouseBuilder builder2 = new GongYuBuilder();
        //调用工程队来修
        HouseDicrector dicrector2 = new HouseDicrector();
        dicrector2.makeHouse(builder2);
        House house2 = builder2.getHouse();
        System.out.println(house2.getFloor());
        System.out.println(house2.getWall());
        System.out.println(house2.getHousetop());
    }

}
