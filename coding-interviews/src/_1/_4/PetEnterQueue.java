package _1._4;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-11 19:51
 **/
public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return pet.getType();
    }
}
