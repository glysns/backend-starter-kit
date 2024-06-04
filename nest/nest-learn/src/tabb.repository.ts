import { DataSource, Repository } from 'typeorm';
import { Injectable } from '@nestjs/common';

import { TabB } from './tabb.entity';

@Injectable()
export class TabBRepository extends Repository<TabB>{
    constructor(private ds:DataSource){
        super(TabB, ds.createEntityManager());
    }
}