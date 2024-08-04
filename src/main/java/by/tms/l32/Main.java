package by.tms.l32;
/**
 * Методы в AccountStorage сделаны под таблицу accounts без столбца telephone_id.
 * */
public class Main {
    public static void main(String[] args) {
        AccountStorage accountStorage = new AccountStorage();


        accountStorage.save(new Account(5,"jack","j","jac@gmail.com"));
        accountStorage.save(new Account(6,"jac","jy","ja@gmail.com"));
        accountStorage.save(new Account(7,"ja","jyu","j@gmail.com"));
        accountStorage.save(new Account(8,"j","jyui","P@gmail.com"));

        accountStorage.removeByID(2);

        System.out.println(accountStorage.getById(1));

        System.out.println(accountStorage.findAll());

    }
}