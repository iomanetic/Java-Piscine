public class UsersArrayList implements UserList {

    private final Integer ARRAY_SIZE = 10;

    private Integer userCount;

    private Integer size;

    private User[] userList;

    public UsersArrayList() {
        this.userList = new User[10];
        this.size = 1;
        this.userCount = 0;
    }

    public void addUser(User user) {
        if(this.userCount + 1 > ARRAY_SIZE * size) {
            size *= 2;
            increaseList();
        }
        userList[userCount] = user;
        userCount++;
    }

    public User getUserWithId(Integer id) throws UserNotFoundException {
        for(int checkId = 0; checkId < userCount; checkId++) {
            if(id.equals(userList[checkId].getId())) {
                return (userList[checkId]);
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public User getUserWithIndex(Integer index) {
        return (this.userList[index]);
    }

    public Integer getNumOfUsers() {
        return (this.userCount);
    }

    private void increaseList() {
        User[] userListNew = new User[ARRAY_SIZE * size];

        for(int count = 0; count < userCount; count++) {
            userListNew[count] = userList[count];
        }
        userList = userListNew;
    }
}
