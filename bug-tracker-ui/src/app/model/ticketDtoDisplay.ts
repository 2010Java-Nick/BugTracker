export class TicketDisplay {
    constructor(
        public ticketId: number,
        public openerName: String,
        public name: String,
        public priorityId: number,
        public statusId: number,
        public status: String,
        public difficultyLevel: number,
        public assignedName: String,
        public createdStr: String,
        public priority: String
    ){ }
}