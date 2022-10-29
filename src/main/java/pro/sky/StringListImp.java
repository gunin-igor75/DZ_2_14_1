package pro.sky;

import pro.sky.Exception.*;

import java.util.Arrays;

public class StringListImp implements StringList {
    private String[] arrayList;
    private int count;

    public String[] getArrayList() {
        return Arrays.copyOf(arrayList, arrayList.length);
    }

    public int getCount() {
        return count;
    }

    public StringListImp(int size) {
        this.arrayList = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullStringException();
        }
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == null) {
                arrayList[i] = item;
                count++;
                return item;
            }
        }
        arrayList = allocArray();
        add(item);
        return item;
    }

    private String[] allocArray() {
        String[] tmp = new String[(int) (arrayList.length * 1.5)];
        System.arraycopy(arrayList, 0, tmp, 0, arrayList.length);
        return tmp;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullStringException();
        }
        if (index < 0 && index >= count) {
            throw new ArrayListOutOfBoundsException();
        }
        if (count == arrayList.length) {
            arrayList = allocArray();
        }
        System.arraycopy(arrayList, index, arrayList,
                index + 1, arrayList.length - index - 1);
        arrayList[index] = item;
        count++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new NullStringException();
        }
        if (index < 0 && index > count) {
            throw new ArrayListOutOfBoundsException();
        }
        arrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = -1;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null && arrayList[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.arraycopy(arrayList, index + 1,
                    arrayList, index, arrayList.length - index - 1);
            arrayList[arrayList.length - 1] = null;
            count--;
            return item;
        }
        throw new NotFoundElemException();
    }

    @Override
    public String remove(int index) {
        if (index < 0 && index >= count) {
            throw new ArrayListOutOfBoundsException();
        }
        String item = arrayList[index];
        System.arraycopy(arrayList, index + 1,
                arrayList, index, arrayList.length - index - 1);
        arrayList[arrayList.length - 1] = null;
        count--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        for (String elem : arrayList) {
            if (elem != null && elem.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null && arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arrayList.length - 1; i >= 0; i--) {
            if (item != null && item.equals(arrayList[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 && index >= count) {
            throw new ArrayListOutOfBoundsException();
        }
        return arrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullStringException();
        }
        StringListImp obj = (StringListImp) otherList;
        if (obj.arrayList.length != arrayList.length) {
            return false;
        }
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null && !arrayList[i].equals(obj.arrayList[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(arrayList, null);
        count = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[count];
        System.arraycopy(arrayList, 0, result, 0, count);
        return result;
    }
}
