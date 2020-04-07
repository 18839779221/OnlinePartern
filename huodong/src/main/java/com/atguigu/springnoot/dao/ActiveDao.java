package com.atguigu.springnoot.dao;

import com.atguigu.springnoot.entities.Active;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ActiveDao  {

    private static Map<Integer, Active> actives = null;

    //    public Active(Integer id, String activeEvent, Dae activeTime, String activeLocation) {}
    static {
        actives = new HashMap<Integer, Active>();

       /* actives.put(1001, new Active(1001, new String("今天有个相亲大会"), new String("新街口")));
        actives.put(1002, new Active(1001, new String("今天有个相亲大会"), new String("夫子庙")));
        actives.put(1003, new Active(1001, new String("今天有个相亲大会"), new String("江陵")));
        actives.put(1004, new Active(1001, new String("今天有个相亲大会"), new String("老门东")));
        actives.put(1005, new Active(1001, new String("今天有个相亲大会"), new String("玄武湖")));*/
    }

    private static Integer initId = 1006;

    public void save(Active active) {
        if (active.getId() == null) {
            active.setId(initId++);
        }

        actives.put(active.getId(), active);
    }

    public Collection<Active> getAll() {
        return actives.values();
    }

    public Active get(Integer id) {
        return actives.get(id);
    }

    public void delete(Integer id) {
        actives.remove(id);
    }


}




