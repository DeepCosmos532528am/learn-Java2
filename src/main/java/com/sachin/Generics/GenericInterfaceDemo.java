

package com.sachin.Generics;
interface genericDemo<K, V> {
    String a = "sas";
    K getKey();
    V getValue();

    void setKey(K key);
    void setValue(V value);
}

class pair<K,V> implements genericDemo<K,V> {
    private K key ;
    private V value ;

    @Override
    public V getValue() {
        System.out.println(a);
        return value;
    }

    @Override
    public K getKey(){
        return key;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
        System.out.println();
    }

    @Override
    public void setKey(K key){
        this.key = key;
    }

}

public class GenericInterfaceDemo {

    static void main() {
        genericDemo<Integer, Integer> gd = new pair<>();
        genericDemo<Integer, String> gd2 = new pair<>();

        System.out.println(gd.a);

        gd.setValue(2);
        gd2.setValue("2");
        System.out.println(gd.equals(gd2));
        System.out.println(gd.getValue());

    }
}

