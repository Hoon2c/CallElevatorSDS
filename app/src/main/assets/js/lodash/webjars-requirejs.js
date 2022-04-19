var webjarsLodashChildren = [
    'lodash',
    'lodash.compat',
    'lodash.underscore'
];
var webjarsLodashPaths = {};
webjarsLodashChildren.forEach(function (child) {
    webjarsLodashPaths[child] = webjars.path("lodash", child);
});
requirejs.config({
    paths: webjarsLodashPaths
});
