export class TicketDisplay {
    constructor(
        public ticketId: number,
        public openerName: String,
        public name: String,
        public priority: String,
        public status: String,
        public difficultyLevel: number,
        public assignedName: String,
        public createdStr: String
    ){ }
}