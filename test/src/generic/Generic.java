package generic;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-08 14:37
 **/
public class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public static void main(String[] args) {
        Generic<Integer> integerGeneric = new Generic<>(123456);
        Generic<String> stringGeneric = new Generic<>("654321str");

        System.out.println(integerGeneric.getKey());
        System.out.println(stringGeneric.getKey());

        Generic generic = new Generic(123);
        Object key = generic.getKey();
    }
}
