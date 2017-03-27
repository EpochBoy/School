public class ElectronicDeviceTest {

    public static void main(String[] args) {

        ElectronicDevice electronicDevice = new ElectronicDevice();

        DiodeLight diodeLight = new DiodeLight(electronicDevice);

        PowerUsage powerUsage = new PowerUsage(electronicDevice);


        //ændre off til 'on', 'hibernate' eller 'off' for andre udskrivninger.
        electronicDevice.setState("hibernate");


    }
}
