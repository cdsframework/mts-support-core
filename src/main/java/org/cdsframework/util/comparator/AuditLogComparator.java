/**
 * The MTS support core project contains client related utilities, data transfer objects and remote EJB interfaces for communication with the CDS Framework Middle Tier Service.
 *
 * Copyright (C) 2016 New York City Department of Health and Mental Hygiene, Bureau of Immunization
 * Contributions by HLN Consulting, LLC
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version. You should have received a copy of the GNU Lesser
 * General Public License along with this program. If not, see <http://www.gnu.org/licenses/> for more
 * details.
 *
 * The above-named contributors (HLN Consulting, LLC) are also licensed by the New York City
 * Department of Health and Mental Hygiene, Bureau of Immunization to have (without restriction,
 * limitation, and warranty) complete irrevocable access and rights to this project.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; THE
 * SOFTWARE IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING,
 * BUT NOT LIMITED TO, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE COPYRIGHT HOLDERS, IF ANY, OR DEVELOPERS BE LIABLE FOR
 * ANY CLAIM, DAMAGES, OR OTHER LIABILITY OF ANY KIND, ARISING FROM, OUT OF, OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information about this software, see https://www.hln.com/services/open-source/ or send
 * correspondence to ice@hln.com.
 */
package org.cdsframework.util.comparator;

import java.util.Comparator;
import org.cdsframework.dto.AuditLogDTO;

/**
 *
 * @author HLN Consulting LLC
 */
public class AuditLogComparator implements Comparator<AuditLogDTO> {

    public enum SortParameter { CREATE_DATETIME_CLASSNAME_AUDIT_ID_ASC }    
    private SortParameter sortParameter = null;
    
    public AuditLogComparator(SortParameter sortParameter) {
        this.sortParameter = sortParameter;
    }
    
    @Override
    public int compare(AuditLogDTO o1, AuditLogDTO o2) {
        int comparison = 0;
        
        if (sortParameter == SortParameter.CREATE_DATETIME_CLASSNAME_AUDIT_ID_ASC) {
            comparison = o1.getCreateDatetime().compareTo(o2.getCreateDatetime());
            if (comparison == 0) {
                comparison = o1.getClassName().compareTo(o2.getClassName());
                if (comparison == 0) {
                    comparison = (o1.getAuditId().compareTo(o2.getAuditId()));
                }
            }
        }
        return comparison;
    }
    
}
