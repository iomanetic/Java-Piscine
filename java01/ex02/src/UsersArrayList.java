public class UsersArrayList implements UserList {

    private final Integer ARRAY_SIZE = 10;

    private Integer userCount;

    private Integer size;

    private User[] userList;

    public UsersArrayList() {
        this.userList = new User[11];
        this.size = 1;
        this.userCount = 0;
    }

    public void addUser(User user) {
        if(this.userCount + 1 > ARRAY_SIZE * size) {
            increaseList();
            size *= 2;
        }
        userList[userCount] = user;
        userCount++;
    }

    public void getUserWithId(Integer id) {

    }

    public void getUserWithIndex(Integer index) {

    }

    public void getNumOfUsers() {

    }

    private void increaseList() {
        User[] userListNew = new User[ARRAY_SIZE * size];

        for(int count = 0; userList[count] != null; count++) {
            userListNew[count] = userList[count];
            count++;
        }
        userList = userListNew;
    }
}
