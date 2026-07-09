@echo off
echo ========================================
echo Building All Services
echo ========================================

echo Building Eureka Discovery Server...
cd eureka-discovery-server
call mvn clean package
cd ..

echo Building Account Service...
cd account-service
call mvn clean package
cd ..

echo Building Loan Service...
cd loan-service
call mvn clean package
cd ..

echo ========================================
echo Starting All Services in Order
echo ========================================

echo 1. Starting Eureka Discovery Server on port 8761...
start cmd /k "cd eureka-discovery-server && mvn spring-boot:run"

timeout /t 10 /nobreak >nul

echo 2. Starting Account Service on port 8080...
start cmd /k "cd account-service && mvn spring-boot:run"

timeout /t 5 /nobreak >nul

echo 3. Starting Loan Service on port 8081...
start cmd /k "cd loan-service && mvn spring-boot:run"

echo ========================================
echo All Services Started!
echo ========================================
echo Eureka Dashboard: http://localhost:8761
echo Account Service:  http://localhost:8080/accounts/12345
echo Loan Service:     http://localhost:8081/loans/H00987987972342
echo ========================================
echo Note: Services will register with Eureka
echo Wait a few seconds for registration
echo ========================================
pause