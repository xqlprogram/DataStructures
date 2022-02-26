package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author xql
 * @create 2021-11-09 13:45
 */
public class main {


    /**
     * 合并两个购物车
     * @param newCarts  登录后的购物车 [{1,苹果,1},{2,香蕉,1},{3,草莓,1}]    1-》{1,苹果,1}  2-》{2,香蕉,1} 3->
     * @param oldCarts  未登录的购物车[{3,草莓,1},{1,苹果,1}]
     * @return    [{1,苹果,2},{2,香蕉,1}，{3,草莓,1}]
     */
    public static List<Cart> hebign(List<Cart> newCarts,List<Cart> oldCarts){
        Map<Integer,Cart> map=newCarts.stream().collect(Collectors.toMap(Cart::getId,v->v));
        for (Cart cart : oldCarts) {
            Integer id = cart.getId();
            Cart vo = map.get(id);
            if(vo!=null){//id
                vo.addCount(cart.getCount());
            }else {
                newCarts.add(cart);
                map.put(id,vo);
            }
        }
        return newCarts;
    }


    public static void main(String[] args) {
        Cart c1 = new Cart(1, "苹果", 1);
        Cart c2 = new Cart(2, "香蕉", 1);

        List<Cart> newCarts = new ArrayList<>();
        newCarts.add(c1);
        newCarts.add(c2);

        Cart c3 = new Cart(3, "草莓", 1);
        Cart c4 = new Cart(1, "苹果", 1);

        List<Cart> oldCarts = new ArrayList<>();
        oldCarts.add(c4);
        oldCarts.add(c4);

        hebign(newCarts,oldCarts).forEach(System.out::println);

    }

}
