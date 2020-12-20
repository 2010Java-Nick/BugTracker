import { Status } from './status';

import {Employee} from './employee';
import { Post } from './post';

export class TicketDto {
    constructor(
        public ticketId: number,
        public opener: Employee,
        public assignedDeveloper: Employee,
        public created: Date,
        public status: Status,
        public name: String,
        public priorityId: number,
        public difficultyLevel: number,
        public body: String,
        public comments: Post[]
    ){ }
}