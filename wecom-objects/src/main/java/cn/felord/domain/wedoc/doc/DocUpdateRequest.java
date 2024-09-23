/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.domain.wedoc.doc;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * The type Update request.
 *
 * @author dax
 * @since 2024 /8/9
 */
@ToString
@Getter
public class DocUpdateRequest {
    /**
     * 替换指定位置文本内容
     */
    private DocReplaceText replaceText;
    /**
     * 在指定位置插入文本内容
     */
    private DocInsertText insertText;
    /**
     * 删除指定位置内容
     */
    private DocDeleteContent deleteContent;
    /**
     * 在指定位置插入图片
     */
    private DocInsertImage insertImage;
    /**
     * 在指定位置插入分页符
     */
    private DocInsertLocation insertPageBreak;
    /**
     * 在指定位置插入表格
     */
    private DocInsertTable insertTable;
    /**
     * 在指定位置插入段落
     */
    private DocInsertLocation insertParagraph;
    /**
     * 更新指定位置文本属性
     */
    private DocUpdateTextProperty updateTextProperty;

    private DocUpdateRequest() {
    }

    /**
     * 替换指定位置文本内容
     *
     * @param text   the text
     * @param ranges the ranges
     * @return the update request
     */
    public static DocUpdateRequest replaceText(String text, Set<DocRange> ranges) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.replaceText = new DocReplaceText(text, ranges);
        return updateRequest;
    }

    /**
     * 在指定位置插入文本内容
     *
     * @param text  the text
     * @param index the index
     * @return the update request
     */
    public static DocUpdateRequest insertText(String text, int index) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.insertText = new DocInsertText(text, index);
        return updateRequest;
    }

    /**
     * 删除指定位置内容
     *
     * @param startIndex the start index
     * @param length     the length
     * @return the update request
     */
    public static DocUpdateRequest deleteContent(int startIndex, int length) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.deleteContent = new DocDeleteContent(startIndex, length);
        return updateRequest;
    }

    /**
     * 在指定位置插入图片
     *
     * @param imageId the image id
     * @param index   the index
     * @param width   the width
     * @param height  the height
     * @return the update request
     */
    public static DocUpdateRequest insertImage(String imageId, int index, int width, int height) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.insertImage = new DocInsertImage(imageId, index, width, height);
        return updateRequest;
    }

    /**
     * 在指定位置插入图片
     *
     * @param imageId the image id
     * @param index   the index
     * @return the update request
     */
    public static DocUpdateRequest insertImage(String imageId, int index) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.insertImage = new DocInsertImage(imageId, index);
        return updateRequest;
    }

    /**
     * 在指定位置插入图片
     *
     * @param insertImage the insert image
     * @return the update request
     */
    public static DocUpdateRequest insertImage(DocInsertImage insertImage) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.insertImage = insertImage;
        return updateRequest;
    }

    /**
     * 在指定位置插入分页符
     *
     * @param index the index
     * @return the update request
     */
    public static DocUpdateRequest insertPageBreak(int index) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.insertPageBreak = new DocInsertLocation(index);
        return updateRequest;
    }

    /**
     * 在指定位置插入表格
     *
     * @param index the index
     * @param rows  the rows
     * @param cols  the cols
     * @return the update request
     */
    public static DocUpdateRequest insertTable(int index, int rows, int cols) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.insertTable = new DocInsertTable(index, rows, cols);
        return updateRequest;
    }

    /**
     * 在指定位置插入段落
     *
     * @param index the index
     * @return the update request
     */
    public static DocUpdateRequest insertParagraph(int index) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.insertParagraph = new DocInsertLocation(index);
        return updateRequest;
    }

    /**
     * 更新指定位置文本属性
     *
     * @param bold            the bold
     * @param color           the color
     * @param backgroundColor the background color
     * @param ranges          the ranges
     * @return the update request
     */
    public static DocUpdateRequest updateTextProperty(boolean bold, String color, String backgroundColor, Set<DocRange> ranges) {
        DocUpdateRequest updateRequest = new DocUpdateRequest();
        updateRequest.updateTextProperty = new DocUpdateTextProperty(bold, color, backgroundColor, ranges);
        return updateRequest;
    }
}
