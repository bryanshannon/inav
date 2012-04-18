/**
 * * INAV - Interactive Network Active-traffic Visualization
 * * Copyright © 2007  Nathan Robinson, Jeff Scaparra
 * *
 * * This file is a part of INAV.
 * *
 * * This program is free software: you can redistribute it and/or modify
 * * it under the terms of the GNU General Public License as published by
 * * the Free Software Foundation, either version 3 of the License, or
 * * (at your option) any later version.
 * *
 * * This program is distributed in the hope that it will be useful,
 * * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * * GNU General Public License for more details.
 * *
 * * You should have received a copy of the GNU General Public License
 * * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * */


#include "clientCommData.h"
#include <iostream>

ClientCommData::ClientCommData( Mutex& coutMutex, Mutex & logMutex,
    				std::ofstream *log, int serverPort ): 
  				BaseData( coutMutex, logMutex, log),
				serverPort_(serverPort)
{
	refreshTime_ = communication::RefreshTime;
}

int ClientCommData::getServerPort()
{
	return serverPort_;
}

int ClientCommData::getRefreshTime()
{
	return refreshTime_;
}

void ClientCommData::setRefreshTime( int time )
{
	refreshTime_ = time;
}
