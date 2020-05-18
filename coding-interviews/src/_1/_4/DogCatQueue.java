package _1._4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-11 19:53
 **/
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!catQ.isEmpty() && !dogQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("queue is empty");
        }
    }

    public Dog pollDog() {
        if (!isDogEmpty()) {
            return (Dog) dogQ.poll().getPet();
        } else {
            throw new RuntimeException("dogQ empty");
        }
    }

    public Cat pollCat() {
        if (!isCatEmpty()) {
            return (Cat) catQ.poll().getPet();
        } else {
            throw new RuntimeException("catQ empty");
        }
    }

    public boolean isEmpty() {
        return isCatEmpty() && isDogEmpty();
    }

    public boolean isDogEmpty() {
        return dogQ.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQ.isEmpty();
    }
}
