package reflect;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-28 17:40
 **/
public class SonClass extends FatherClass {

    private String mSonName;
    protected int mSonAge;
    public String mSonBirthday;

    public void printSonMsg() {
        System.out.println("Son Msg - name : "
                + mSonName + "; age : " + mSonAge);
    }

    private void setSonName(String name) {
        mSonName = name;
    }

    private void setSonAge(int age) {
        mSonAge = age;
    }

    private int getSonAge() {
        return mSonAge;
    }

    private String getSonName() {
        return mSonName;
    }
}
