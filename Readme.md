codes available to fork from below branch
https://github.com/raushanmca/microservices/branches

Deployment sequence
1-> DiscoveryServer
2-> API-Gateway
3-> EmployeeService
4-> DepartmentService

once deployment is successfull, API available
: Eureka server url http://hostname:8761
: API gateway url http://hostname:1111
: Employee Service url http://hostname:9002
: Department Service url http://hostname:9001

1: To create department use following API to create and search department

          a: Create department
            http://hostname:9001/department/

            method : POST

            payload
               {
                 "name": "dept1",
             "id":1
            }

         b: Search department
         method : GET
         http://hostname:9001/department/{deptid}

2: token url

       a:  http://localhost:9002/authenticate

        payload data

              {
                 "username":"sdadmin",
                 "password":"password"
              }

        As of now we have four user using which we can create jwt token
                    1: admin,
                    2: sdadmin,
                    3: arun
                    4: raushan
                All user and password is hardcoded in user service, for demo purpose, in actual env this can be featch from DB

3: Once token created using this we can create employee using below api with payload

        a: http://localhost:9002/employee/

         method : POST
         header : Authorization : "Bearer <token created in step two>
            {
             "name" : "arun",
             "deptId" :"1" // department id from departmet service created in step 1

            }

        b: Search API
         method : GET
         header : Authorization : "Bearer <token created in step two>
             http://localhost:9002/employee/{empid}

       -- using get API if token belongs to current emplId id then the response will be

             o/p
             {
                "employee": {
                    "id": 2,
                    "name": "arun",
                    "deptId": 1
                },
                "departmet": {
                    "id": 1,
                    "name": "dept1"
                }
            }
       -- if token belong to other user, then the response will be below

        {
            "employee": {
                "id": 2,
                "name": "arun",
                "deptId": 1
            },
            "departmet": {
                "id": 404,
                "name": "**********"
            }
        }

Note : All projects are maven project
API (department, employee) can also be access using the GateWay url :http://hostname:1111/employee/, http://hostname:1111/department/
