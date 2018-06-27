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

import java.util.Date;
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
import org.cdsframework.enumeration.NotificationState;
import org.cdsframework.enumeration.NotificationStatus;
import org.cdsframework.enumeration.NotificationType;

/**
 *
 * @author sdn
 */
@Entity
@Table(databaseId = "MTS", name = "notification_state", view = "vw_notification_state")
@JndiReference(root = "mts-ejb-core")
@Permission(name = "Notification State")
@XmlRootElement(name = "NotificationState")
public class NotificationStateDTO extends BaseDTO {

    private static final long serialVersionUID = -8884287855920724956L;

    public interface ByNotificationId {
    }

    public interface ByUserId {
    }

    public interface ByDashboard {
    }

    public interface ByInbox {
    }

    public interface UnreadMessageCount {
    }

    public interface ByRecipientId {
    }

    public interface ByRecipientIdUserId {
    }

    @GeneratedValue(source = GenerationSource.AUTO)
    @Id
    @Size(max = 32)
    private String stateId;
    @GeneratedValue(source = GenerationSource.FOREIGN_CONSTRAINT, sourceClass = NotificationRecipientDTO.class)
    private String recipientId;
    @NotNull
    private NotificationState state;
    @ReferenceDTO
    @Column(name = "user_id")
    private UserDTO userDTO;
    @Column(name = "status", insertable = false, updateable = false, selectable = true)
    private NotificationStatus status;
    @Column(name = "notification_type", insertable = false, updateable = false, selectable = true)
    private NotificationType type;
    @Column(name = "notification_time", insertable = false, updateable = false, selectable = true)
    private Date notificationTime;
    @Column(name = "message_title", insertable = false, updateable = false, selectable = true)
    private String messageTitle;
    @Column(name = "message_body", insertable = false, updateable = false, selectable = true)
    private String messageBody;
    @Column(name = "notification_id", insertable = false, updateable = false, selectable = true)
    private String notificationId;
    @Column(name = "update_time", insertable = false, updateable = false, selectable = true)
    private Date updateTime;

    /**
     * Get the value of updateTime
     *
     * @return the value of updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * Set the value of updateTime
     *
     * @param updateTime new value of updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Get the value of messageBody
     *
     * @return the value of messageBody
     */
    public String getMessageBody() {
        return messageBody;
    }

    /**
     * Set the value of messageBody
     *
     * @param messageBody new value of messageBody
     */
    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    /**
     * Get the value of messageTitle
     *
     * @return the value of messageTitle
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * Set the value of messageTitle
     *
     * @param messageTitle new value of messageTitle
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    /**
     * Get the value of notificationTime
     *
     * @return the value of notificationTime
     */
    public Date getNotificationTime() {
        return notificationTime;
    }

    /**
     * Set the value of notificationTime
     *
     * @param notificationTime new value of notificationTime
     */
    public void setNotificationTime(Date notificationTime) {
        this.notificationTime = notificationTime;
    }

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public NotificationType getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(NotificationType type) {
        this.type = type;
    }

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public NotificationStatus getStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(NotificationStatus status) {
        this.status = status;
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
     * Get the value of state
     *
     * @return the value of state
     */
    public NotificationState getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    @PropertyListener
    public void setState(NotificationState state) {
        this.state = state;
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

    /**
     * Get the value of stateId
     *
     * @return the value of stateId
     */
    public String getStateId() {
        return stateId;
    }

    /**
     * Set the value of stateId
     *
     * @param stateId new value of stateId
     */
    @PropertyListener
    public void setStateId(String stateId) {
        this.stateId = stateId;
    }
}
