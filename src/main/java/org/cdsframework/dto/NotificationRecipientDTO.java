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
package org.cdsframework.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.cdsframework.annotation.Column;
import org.cdsframework.annotation.Entity;
import org.cdsframework.annotation.GeneratedValue;
import org.cdsframework.annotation.Id;
import org.cdsframework.annotation.JndiReference;
import org.cdsframework.annotation.Permission;
import org.cdsframework.annotation.ReferenceDTO;
import org.cdsframework.annotation.Table;
import org.cdsframework.aspect.annotations.PropertyListener;
import org.cdsframework.base.BaseDTO;
import org.cdsframework.enumeration.GenerationSource;
import org.cdsframework.enumeration.NotificationRecipientType;

/**
 *
 * @author sdn
 */
@Entity
@Table(databaseId = "MTS", name = "notification_recipient")
@JndiReference(root = "mts-ejb-core")
@Permission(name = "Notification Recipient")
@XmlRootElement(name = "NotificationRecipient")
public class NotificationRecipientDTO extends BaseDTO {

    private static final long serialVersionUID = -3631331366229047438L;

    public interface ByNotificationId {
    }

    @GeneratedValue(source = GenerationSource.AUTO)
    @Id
    @Size(max = 32)
    private String recipientId;
    @GeneratedValue(source = GenerationSource.FOREIGN_CONSTRAINT, sourceClass = NotificationDTO.class)
    private String notificationId;
    @ReferenceDTO
    @Column(name = "scheme_id")
    private SecuritySchemeDTO securitySchemeDTO;
    @ReferenceDTO
    @Column(name = "user_id")
    private UserDTO userDTO;
    @NotNull
    private NotificationRecipientType recipientType;

    /**
     * Get the value of recipientType
     *
     * @return the value of recipientType
     */
    public NotificationRecipientType getRecipientType() {
        return recipientType;
    }

    /**
     * Set the value of recipientType
     *
     * @param recipientType new value of recipientType
     */
    @PropertyListener
    public void setRecipientType(NotificationRecipientType recipientType) {
        this.recipientType = recipientType;
    }

    /**
     * Get the value of userDTO
     *
     * @return the value of userDTO
     */
    public UserDTO getUserDTO() {
        return userDTO;
    }

    /**
     * Set the value of userDTO
     *
     * @param userDTO new value of userDTO
     */
    @PropertyListener
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    /**
     * Get the value of securitySchemeDTO
     *
     * @return the value of securitySchemeDTO
     */
    public SecuritySchemeDTO getSecuritySchemeDTO() {
        return securitySchemeDTO;
    }

    /**
     * Set the value of securitySchemeDTO
     *
     * @param securitySchemeDTO new value of securitySchemeDTO
     */
    @PropertyListener
    public void setSecuritySchemeDTO(SecuritySchemeDTO securitySchemeDTO) {
        this.securitySchemeDTO = securitySchemeDTO;
    }

    /**
     * Get the value of notificationId
     *
     * @return the value of notificationId
     */
    public String getNotificationId() {
        return notificationId;
    }

    /**
     * Set the value of notificationId
     *
     * @param notificationId new value of notificationId
     */
    @PropertyListener
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Get the value of recipientId
     *
     * @return the value of recipientId
     */
    public String getRecipientId() {
        return recipientId;
    }

    /**
     * Set the value of recipientId
     *
     * @param recipientId new value of recipientId
     */
    @PropertyListener
    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

}
