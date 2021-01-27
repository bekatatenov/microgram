package com.microgram.microgram.annotations;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/***
 * Swagger 2 криво обрабатывает параметры с типом данных Pageable
 * И эта аннотация используется для исправления этой проблемы
 * Эту аннотацию необходимо применять на метод контроллера,
 * в котором применяется Pageable
 *
 * Использование этой аннотации требуется ТОЛЬКО при использовании Swagger 2
 *
 * Дополнительно к этой аннотации необходимо указать @ApiIgnore на параметр Pageable
 * Например:
 * <b>@ApiPageable</b>
 * public List&lt;MovieDTO&gt; findMovies(<b>@ApiIgnore</b> Pageable pageable) {
 */

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataType = "int", paramType = "query", defaultValue = "0", value = "Results page you want to retrieve (0..N)"),
        @ApiImplicitParam(name = "size", dataType = "int", paramType = "query", defaultValue = "20", value = "Number of records per page."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). "
                + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
public @interface ApiPageable {
}