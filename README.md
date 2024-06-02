# myapp
# Commands to execute to apply configurations

kubectl apply -f mysql-configMap.yaml

kubectl apply -f mysql-secrets.yaml

kubectl apply -f db-statefulset.yaml

kubectl apply -f app-deployment.yaml

kubectl apply -f app-hpa.yaml


# Create a table emp with dummy values in mysql pod

kubectl exec -it mysql-0 /bin/bash

mysql -h mysql -u root -p  (password=root)

SHOW databases;

CREATE DATABASE mydatabase;

USE mydatabase;

CREATE TABLE emp (
    emp_id SERIAL PRIMARY KEY,
    emp_name VARCHAR(100),
    emp_salary NUMERIC(10, 2),
    emp_department VARCHAR(100)
);

INSERT INTO emp (emp_name, emp_salary, emp_department) VALUES
    ('John Doe', 50000.00, 'Engineering'),
    ('Jane Smith', 60000.00, 'Marketing'),
    ('Michael Johnson', 55000.00, 'Finance');

select * from emp;

# Access emp table values using api service

kubectl exec -it <pod-name for myapp> -- /bin/sh

apt-get update && apt-get install -y curl

curl http://<Node-IP>:<NodePort>

curl http://192.168.65.3:32000/emp  - to fetch emp records   (IP address and NodePort)