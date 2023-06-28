<template>
  <div v-if="isExternal(iconClass)" :style="styleExternalIcon" class="svg-external-icon svg-icon" v-on="$attrs" />
  <svg v-else :class="svgClass" aria-hidden="true" v-on="$attrs">
    <use :xlink:href="iconName" />
  </svg>
</template>

<script lang="ts" setup>
import { computed, useAttrs } from 'vue';

const props = defineProps({
  iconClass: {
    type: String,
    required: true
  },
  className: {
    type: String,
    default: ''
  }
});
const $attrs = useAttrs();
const iconName = computed(() => {
  return `#icon-${props.iconClass}`
});
const svgClass = computed(() => {
  if (props.className) {
    return 'svg-icon ' + props.className
  } else {
    return 'svg-icon'
  }
})
const styleExternalIcon = computed(() => {
  return {
    mask: `url(${props.iconClass}) no-repeat 50% 50%`,
    '-webkit-mask': `url(${props.iconClass}) no-repeat 50% 50%`
  }
});

function isExternal(path: string) {
  return /^(https?:|mailto:|tel:)/.test(path)
}
</script>

<script lang="ts">
export default {
  name: 'SvgIcon'
}
</script>

<style scoped>
.svg-icon {
  width: 1em;
  height: 1em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
}

.svg-external-icon {
  background-color: currentColor;
  mask-size: cover !important;
  display: inline-block;
}
</style>
