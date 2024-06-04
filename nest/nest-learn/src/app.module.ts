import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TypeOrmModule } from '@nestjs/typeorm';

import { TabA } from './taba.entity';
import { TabB } from './tabb.entity';

import { TabAController } from './taba.controller';
import { TabAService } from './taba.service';
import { TabARepository } from './taba.repository';
import { TabBRepository } from './tabb.repository';

@Module({
  imports: [

    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'root',
      password: 'root',
      database: 'nest',
      entities: [TabA, TabB],
      synchronize: true,
      logging: true
    }),

  ],
  controllers: [AppController, TabAController],
  providers: [AppService, TabAService, TabARepository,TabBRepository],
})
export class AppModule {}
