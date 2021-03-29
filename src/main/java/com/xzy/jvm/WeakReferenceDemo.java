package com.xzy.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        ReferenceQueue<RoleDTO> referenceQueue = new ReferenceQueue<>();
        WeakReference<RoleDTO> weakReference = new WeakReference<>(new RoleDTO(3, "CFO"), referenceQueue);
        
        System.out.println("GC执行前----");
        Reference<? extends RoleDTO> reference;
        while ((reference = referenceQueue.poll()) != null) {
            //如果使用继承的方式就可以包含其他信息了
            System.out.println("referenceQueue中：" + reference);
        }
        
        System.gc();
        try {
            //给GC留点时间，保证GC执行完成
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("GC执行后----");
        if (weakReference.get() == null) {
            System.out.println("弱引用指向的RoleDTO对象 已经被回收");
        }
        Reference<? extends RoleDTO> reference2;
        while ((reference2 = referenceQueue.poll()) != null) {
            //如果使用继承的方式就可以包含其他信息了
            System.out.println("referenceQueue中：" + reference2);
        }
        
    }
}

//随便创建个对象
class RoleDTO {
    private Integer id;
    private String type;
    
    public RoleDTO(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}