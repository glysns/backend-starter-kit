import { Controller, Get, Post, Body } from '@nestjs/common';
import { TabA } from './taba.entity';
import { TabAService } from './taba.service';


@Controller('taba')
export class TabAController {

    constructor(
        private readonly service: TabAService,
      ) {}
    
  @Post()
  async create(@Body() entity:TabA)  {
    return this.service.save(entity);  
    
  }
}