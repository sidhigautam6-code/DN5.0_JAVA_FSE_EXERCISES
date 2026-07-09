@echo off
echo ========================================
echo Testing Account Service
echo ========================================
curl http://localhost:8080/accounts/12345
echo.
echo.
echo ========================================
echo Testing Loan Service
echo ========================================
curl http://localhost:8081/loans/H00987987972342
echo.
pause