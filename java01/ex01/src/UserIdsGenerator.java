public class UserIdsGenerator {

    private static UserIdsGenerator IdGenerate;

    private static Integer userId = 0;

    private UserIdsGenerator() { }

    public static UserIdsGenerator getInstance() {
        if(IdGenerate == null)
            IdGenerate = new UserIdsGenerator();
        return (IdGenerate);
    }

    public Integer generateId() {
        userId++;
        return (userId);
    }
}
