# Notes

## Tests

 * test avec plusieurs common-services
 	l'appel au common-services est il round robin^?
 	=> il se fait sur les toutes les instances, mais pas en round robin.
 * test avec common service non démarré :
 	est ce qu'on peut démarrer helloworld ?
 * test appel alors que common-service n'est pas démarré :
 	=> erreur non parlante au niveau appelant. A améliorer (TODO) :
 	
	 	2016-05-28 20:21:59.405 ERROR 6485 --- [nio-8080-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is com.netflix.hystrix.exception.HystrixRuntimeException: info timed-out and no fallback available.] with root cause
	
	java.util.concurrent.TimeoutException: null
		at com.netflix.hystrix.AbstractCommand$9.call(AbstractCommand.java:600) ~[hystrix-core-1.5.2.jar:1.5.2]
		at com.netflix.hystrix.AbstractCommand$9.call(AbstractCommand.java:580) ~[hystrix-core-1.5.2.jar:1.5.2]
		at rx.internal.operators.OperatorOnErrorResumeNextViaFunction$4.onError(OperatorOnErrorResumeNextViaFunction.java:139) ~[rxjava-1.1.5.jar:1.1.5]
		at rx.internal.operators.OperatorDoOnEach$1.onError(OperatorDoOnEach.java:71) ~[rxjava-1.1.5.jar:1.1.5]
		at rx.internal.operators.OperatorDoOnEach$1.onError(OperatorDoOnEach.java:71) ~[rxjava-1.1.5.jar:1.1.5]
		at com.netflix.hystrix.AbstractCommand$HystrixObservableTimeoutOperator$1.run(AbstractCommand.java:953) ~[hystrix-core-1.5.2.jar:1.5.2]
		at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable$1.call(HystrixContextRunnable.java:41) ~[hystrix-core-1.5.2.jar:1.5.2]
		at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable$1.call(HystrixContextRunnable.java:37) ~[hystrix-core-1.5.2.jar:1.5.2]
		at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable.run(HystrixContextRunnable.java:57) ~[hystrix-core-1.5.2.jar:1.5.2]
		at com.netflix.hystrix.AbstractCommand$HystrixObservableTimeoutOperator$2.tick(AbstractCommand.java:970) ~[hystrix-core-1.5.2.jar:1.5.2]
		at com.netflix.hystrix.util.HystrixTimer$1.run(HystrixTimer.java:99) ~[hystrix-core-1.5.2.jar:1.5.2]
		at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) ~[na:1.8.0_91]
		at java.util.concurrent.FutureTask.runAndReset(FutureTask.java:308) ~[na:1.8.0_91]
		at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$301(ScheduledThreadPoolExecutor.java:180) ~[na:1.8.0_91]
		at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:294) ~[na:1.8.0_91]
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) ~[na:1.8.0_91]
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) ~[na:1.8.0_91]
		at java.lang.Thread.run(Thread.java:745) [na:1.8.0_91]

 * test avec commonservice démarré sur port normal - appel de helloworld, puis A/R common service sur un autre port.
 	le rappel de helloworld marche t'il tout de suite ?
 	=> non, il faut une trentaine de secondes (le client du discovery service - cad helloworld ne doit se synchroniser que toutes les 30 secondes - réglable dans conf Spring)
 	
 	
# TODO

 * Mettre tous les projets sous un seul projet parent puis remontée dans GitHub
 * Event logging Logging vers ELK (ou Elastic search + mongo DB ?)
 * Suivi avec Spring Cloud Sturc
 * clustering avec Kubernetes
 * Supervision (metrics)
 * OAuth
 * Spring Cloud Config refresh cluster