package com.test.javaarchitect.disruptor.helloworld;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class LongEventMain {
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();//创建一个线程池，供disruptor构造使用
		LongEventFactory eventFactory = new LongEventFactory();//创建工厂
		int ringBufferSize = 1024 * 1024;//缓冲区大小
		//ProducerType.SINGLE 1个生产者 ，MULTI 多个生产者
		Disruptor disruptor = new Disruptor<LongEvent>(eventFactory, ringBufferSize, executor,ProducerType.SINGLE, new YieldingWaitStrategy());
//		Disruptor默认的等待策略是BlockingWaitStrategy。这个策略的内部适用一个锁和条件变量来控制线程的执行和等待（Java基本的同步方法）。BlockingWaitStrategy是最慢的等待策略，但也是CPU使用率最低和最稳定的选项。然而，可以根据不同的部署环境调整选项以提高性能。
//		SleepingWaitStrategy
//		和BlockingWaitStrategy一样，SpleepingWaitStrategy的CPU使用率也比较低。它的方式是循环等待并且在循环中间调用LockSupport.parkNanos(1)来睡眠，（在Linux系统上面睡眠时间60µs）.然而，它的优点在于生产线程只需要计数，而不执行任何指令。并且没有条件变量的消耗。但是，事件对象从生产者到消费者传递的延迟变大了。SleepingWaitStrategy最好用在不需要低延迟，而且事件发布对于生产者的影响比较小的情况下。比如异步日志功能。
//		YieldingWaitStrategy
//		YieldingWaitStrategy是可以被用在低延迟系统中的两个策略之一，这种策略在减低系统延迟的同时也会增加CPU运算量。YieldingWaitStrategy策略会循环等待sequence增加到合适的值。循环中调用Thread.yield()允许其他准备好的线程执行。如果需要高性能而且事件消费者线程比逻辑内核少的时候，推荐使用YieldingWaitStrategy策略。例如：在开启超线程的时候。
//		BusySpinWaitStrategy
//		BusySpinWaitStrategy是性能最高的等待策略，同时也是对部署环境要求最高的策略。这个性能最好用在事件处理线程比物理内核数目还要小的时候。例如：在禁用超线程技术的时候。
		disruptor.handleEventsWith(new LongEventHandle());
		disruptor.start();
		
		RingBuffer ringBuffer = disruptor.getRingBuffer();
//		LongEventProduce producer  = new LongEventProduce(ringBuffer); 
		LongEventProducerWithTranslator producer  = new LongEventProducerWithTranslator(ringBuffer);//这两种方式都可以
	
		ByteBuffer bb = ByteBuffer.allocate(8);
		
		for(long a=1l;a<1000;a++) {
			bb.putLong(0,a);
			producer.onData(bb);
		}
		
		disruptor.shutdown();
		executor.shutdown();
	}
}



























