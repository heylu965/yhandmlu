package com.yh.yhandmlu.代理.staticProxy;

/**
 * 静态代理
 */
public class SimpleStaticProxy {

    static interface IService{
        public void sayHello();
    }

    static class RealService implements IService{

        @Override
        public void sayHello() {
            System.out.println("realService hello");
        }
    }

    /**
     * 代理类
     * 被代理的类，作为一个字段，在构造代理类时，传入；
     */
    static class TraceProxy implements IService{

        private IService iService;

        public TraceProxy(IService iService){
            this.iService = iService;
        }

        @Override
        public void sayHello() {
            System.out.println("in traceService...");
            iService.sayHello();
            System.out.println("out traceService...");
        }


        public static void main(String[] arg){
            IService iService = new RealService();
            TraceProxy proxy = new TraceProxy(iService);
            proxy.sayHello();
        }
    }
}
