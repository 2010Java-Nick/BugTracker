export class TicketDto {
    constructor(
        public openerId: number,
        public name: String,
        public priorityId: number,
        public difficultyLevel: number,
        public body: String
    ) { }
}