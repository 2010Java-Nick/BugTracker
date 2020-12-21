export class Employee {
    
    constructor(
    public employeeId: number,
    public emailAddress: string,
    public password: string,
    public firstName: string,
    public lastName: string,
    public expPoints: number,
    public token?: string,
    ) { }
    
 
}