(function($) {
    var $accessConfigUL = $("#access-config-ul");
    var $accessConfigForm = $("#accessConfigForm");
    var $groupContainer = $("#groupContainer");

    $.getJSON("api/fullMenu.json", function(data) {
        if(data) {
            if(data.children) {
                for(var index in data.children) {
                    $accessConfigUL.append(generateLi(data.children[index], 1));
                }
            }
        }
    });

    $accessConfigUL.on("mouseenter", "a", function(evt) {
        var $target = $(evt.currentTarget);

        $accessConfigUL.find("li.open").not($target.parents("li")).removeClass("open");
        $target.parent("li").addClass("open");

        evt.preventDefault();
        evt.stopPropagation();
        return false;
    });

    $accessConfigUL.on("click", "a:not(.action)", function(evt) {
        var $button = $(evt.currentTarget);
        doToggleAccess($button);

        evt.preventDefault();
        evt.stopPropagation();
        return false;
    });

    $accessConfigUL.on("click", "li.leaf > a.action", function(evt) {
        // TODO trigger ajax call to retrieve page maybe
        var $actionBtn = $(evt.currentTarget);
        var path = $actionBtn.parent("li").data("path");

        var roleId = $accessConfigForm.find("input#id").val();
        console.debug(roleId);
        $.ajax("accessConfig/group.d", {
            "data" : {
                "id" : roleId,
                "path" : path
            },
            "success" : function(data) {
                $groupContainer.html(data);
            }
        });
        console.debug(path);
    });

    function generateLi(data, level) {
        var $li = $(document.createElement("li"));

        var $anchor = $(document.createElement("a"));
        $anchor.attr("href", "#");
        var indicatorspan = document.createElement("div");
        indicatorspan.className = "indicator";
        $anchor.append(indicatorspan);
        $anchor.append(data.name);
        if(level == 1) {
            $anchor.append($(document.createElement("b")).addClass("caret"));
        }

        $li.append($anchor);
        $li.addClass("dropdown");
        if(data.children && data.children.length > 0) {
            // has children, apply classes
            if(level > 1) {
                $li.addClass("dropdown-submenu");
            }

            var $ul = $(document.createElement("ul"));
            $ul.addClass("dropdown-menu");
            $anchor.attr("data-toggle", "dropdown");

            for(var index in data.children) {
                $ul.append(generateLi(data.children[index], level + 1));
            }

            $li.append($ul);
        } else {
            // doesn't have children, is a leaf.
            $li.addClass("leaf");
            $li.data("path", data.path);

            var actionDiv = document.createElement("a");
            actionDiv.className = "action glyphicon glyphicon-log-in";
            $li.append(actionDiv);
        }

        return $li;
    }

    function doToggleAccess($button) {
        // TODO toggle access
        var $parentLi = $button.parent("li");
        var $children = $parentLi.find("a");

        if($button.is(".halfcheck")) {
            $children.removeClass("halfcheck");
            $children.addClass("fullcheck");
        } else if($button.is(".fullcheck")) {
            $children.removeClass("fullcheck");
        } else {
            $children.addClass("fullcheck");
        }

        checkParents($parentLi);
    }

    function checkParents($li) {
        var $parentLi = $li.parent().closest("li");
        if($parentLi.length == 0) {
            return;
        }
        var $parentLiAnchor = $parentLi.children("a");

        var $siblingAnchors = $li.siblings("li").children("a").add($li.children("a"));
        var $fullchecks = $siblingAnchors.filter(".fullcheck");
        var $halfchecks = $siblingAnchors.filter(".halfcheck");

        if($fullchecks.length > 0 || $halfchecks.length > 0) {
            if($siblingAnchors.length == $fullchecks.length) {
                // all are checked
                $parentLiAnchor.removeClass("halfcheck");
                $parentLiAnchor.addClass("fullcheck");
            } else {
                $parentLiAnchor.removeClass("fullcheck");
                $parentLiAnchor.addClass("halfcheck");
            }
        } else {
            $parentLiAnchor.removeClass("fullcheck halfcheck")
        }
        checkParents($parentLi);
    }
}(jQuery))