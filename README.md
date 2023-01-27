# CapillaryAssignment

 ![image](https://user-images.githubusercontent.com/56399477/215124131-e06e6c9c-2216-4bc5-867f-2e794af2f052.png)


1. Run the ReadService Application and BookStoreService Application.
2. Send a get Request to the Api -> http ://localhost:8080/recommended.
3. If the BookStoreService will be up it will send the response as “Service is up”, else it will send response as “Service is down” (Which is a fallback method implemented In ReadService Application).
4. The configuration for Circuit Breaker is done in application.yml file of ReadService Application.
    * The failure Rate threshold is set to 50, which means if 50% of request fails the state of circuit will change from CLOSED to OPEN.
    * The minimum number of calls is set to 5, wait duration in open state is set to 5sec and automatic Transition from Open to half-open is set to be True, which means that after the circuit breaker state has changed from CLOSED to OPEN. It will automatically change its state from OPEN to HALF-OPEN after 5 seconds.
    * Failure rate in half open state is set to 3 which means if failure threshold is less than 50% than the circuit breaker state will change to CLOSED, else it will again set its to OPEN.

Note : - I have also used actuator to monitor the application and to know what is the state of the circuit breaker (http://localhost:9080/actuator/health).





	Initially The circuit breaker is in CLOSED State.
![image](https://user-images.githubusercontent.com/56399477/215124228-ecc1ce5b-8710-43aa-a39f-df182e59de02.png)

 
	When the service will be down and the threshold value reaches above 50% the circuit breaker state will change form CLOSED to OPEN.
![image](https://user-images.githubusercontent.com/56399477/215124264-89021b0e-96d7-4f0c-ad16-bfbabdc496df.png)

 

After 5 seconds the state will automatically change from OPEN to HALF-OPEN.
![image](https://user-images.githubusercontent.com/56399477/215124303-57ddccc4-ca79-4280-9ace-21e2aa4d324d.png)

 
