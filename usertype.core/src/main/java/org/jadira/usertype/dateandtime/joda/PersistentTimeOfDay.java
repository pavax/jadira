/*
 *  Copyright 2010, 2011 Christopher Pheby
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.jadira.usertype.dateandtime.joda;

import java.sql.Time;

import org.hibernate.usertype.ParameterizedType;
import org.jadira.usertype.dateandtime.joda.columnmapper.TimeColumnTimeOfDayMapper;
import org.jadira.usertype.spi.shared.AbstractParameterizedUserType;
import org.jadira.usertype.spi.shared.IntegratorConfiguredType;
import org.joda.time.TimeOfDay;

/**	
 * Persist {@link TimeOfDay} via Hibernate as a SQL TIME datatype - note that sub-second values will not
 * be retained. This type is basically compatible with org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime.
 * However, note that org.joda.time.contrib.hibernate.PersistentTimeOfDayAsTime contains a bug where times written
 * down will be offset from GMT due to its use of {@link java.sql.Time#setTime(long)}. This class is not affected by this
 * issue, but this means you cannot rely on the interpretation of this type to be the same for both classes.
 * 
 * The type is stored using UTC timezone.
 *
 * Alternatively provide the 'databaseZone' parameter in the {@link org.joda.time.DateTimeZone#forID(String)} format
 * to indicate the zone of the database. 
 * N.B. To use the zone of the JVM supply 'jvm'
 * 
 * @deprecated Recommend replacing use of {@link TimeOfDay} with {@link org.joda.time.LocalTime} and {@link PersistentLocalTime}
 */
public class PersistentTimeOfDay extends AbstractParameterizedUserType<TimeOfDay, Time, TimeColumnTimeOfDayMapper> implements ParameterizedType, IntegratorConfiguredType {

    private static final long serialVersionUID = -7674573524546389213L;
}
