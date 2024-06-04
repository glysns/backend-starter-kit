import { DataSource, Repository } from 'typeorm';
import { Injectable } from '@nestjs/common';

import { TabA } from './taba.entity';

@Injectable()
export class TabARepository extends Repository<TabA>{
    constructor(private ds:DataSource){
        super(TabA, ds.createEntityManager());
    }
}